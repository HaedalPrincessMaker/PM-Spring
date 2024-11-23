package PrincessMaker.PM_Spring.service;

import PrincessMaker.PM_Spring.repository.EmitterRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class NotificationService {

    private final EmitterRepository emitterRepository;

    public NotificationService(EmitterRepository emitterRepository) {
        this.emitterRepository = emitterRepository;
    }

    /**
     * 클라이언트 구독 처리
     */
    public SseEmitter subscribe(Long userId, String lastEventId) {
        SseEmitter emitter = new SseEmitter(60_000L); // 60초 유지
        emitterRepository.save(userId, emitter);

        emitter.onCompletion(() -> emitterRepository.deleteById(userId));
        emitter.onTimeout(() -> emitterRepository.deleteById(userId));
        emitter.onError((e) -> emitterRepository.deleteById(userId));

        try {
            emitter.send(SseEmitter.event().name("INIT").data("Connected!"));
        } catch (Exception e) {
            emitterRepository.deleteById(userId);
        }

        return emitter;
    }

    /**
     * 특정 사용자에게 알림 전송
     */
    public void sendToClient(SseEmitter emitter, Long userId, String message) {
        try {
            emitter.send(SseEmitter.event().name("NOTIFICATION").data(message));
        } catch (Exception e) {
            emitterRepository.deleteById(userId);
        }
    }

    /**
     * 모든 사용자에게 알림 브로드캐스트
     */
    public void sendBroadcast(String message) {
        emitterRepository.findAll().forEach((userId, emitter) -> {
            try {
                emitter.send(SseEmitter.event().name("BROADCAST").data(message));
            } catch (Exception e) {
                emitterRepository.deleteById(userId);
            }
        });
    }
}
