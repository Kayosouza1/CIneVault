package com.java.kayo.cinevault.service;

import com.java.kayo.cinevault.Entity.Streaming;
import com.java.kayo.cinevault.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }

    public List<Streaming> findAll() {
        return streamingRepository.findAll();
    }

    public Streaming saveStreaming(Streaming streaming) {
        Streaming savedStreaming = streamingRepository.save(streaming);
        if (savedStreaming != null) {
            return streamingRepository.save(streaming);
        }
        return null;
    }

    public Optional<Streaming> findById(Long id) {
        return streamingRepository.findById(id);

    }

    public void deleteById(Long id) {
        streamingRepository.deleteById(id);
    }
}
