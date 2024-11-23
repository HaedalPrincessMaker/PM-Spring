package PrincessMaker.PM_Spring.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Repository
public class EmitterRepository {

    // Emitter 저장소
    private final Map<Long, SseEmitter> emitters = new ConcurrentHashMap<>();

    /**
     * Emitter 추가
     *
     * @param userId  유저 ID
     * @param emitter SseEmitter 객체
     */
    public void save(Long userId, SseEmitter emitter) {
        emitters.put(userId, emitter);
    }

    /**
     * Emitter 조회
     *
     * @param userId 유저 ID
     * @return SseEmitter 객체
     */
    public SseEmitter findById(Long userId) {
        return emitters.get(userId);
    }

    /**
     * Emitter 삭제
     *
     * @param userId 유저 ID
     */
    public void deleteById(Long userId) {
        emitters.remove(userId);
    }

    /**
     * 모든 Emitter 반환
     *
     * @return 전체 Emitter Map
     */
    public Map<Long, SseEmitter> findAll() {
        return emitters;
    }
}

