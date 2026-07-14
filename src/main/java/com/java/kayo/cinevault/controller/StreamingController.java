package com.java.kayo.cinevault.controller;

import com.java.kayo.cinevault.Entity.Streaming;
import com.java.kayo.cinevault.docs.StreamingControllerDoc;
import com.java.kayo.cinevault.mapper.StreamingMapper;
import com.java.kayo.cinevault.request.StreamingRequest;
import com.java.kayo.cinevault.response.StreamingResponse;
import com.java.kayo.cinevault.service.StreamingService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinevault/streaming")
public class StreamingController implements StreamingControllerDoc {

    private final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAllStreaming() {
        List<Streaming> streamings = streamingService.findAll();
        List<StreamingResponse> list = streamings.stream().map(StreamingMapper::toStreamingResponse).toList();

        return ResponseEntity.ok(list);
    }

    @PostMapping("/save")
    public ResponseEntity<StreamingResponse> saveStreaming(@Valid @RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = streamingService.saveStreaming(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id) {
        return streamingService.findById(id).map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming))).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStreaming(@PathVariable Long id) {
        try {
            streamingService.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();
    }


//    public ResponseEntity<?> deleteStreaming(@PathVariable Long id) {
//        Optional<Streaming> streaming = streamingService.findById(id);
//        if (streaming.isPresent()) {
//            try {
//                streamingService.deleteById(id);
//                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//            } catch (DataIntegrityViolationException e) {
//                return ResponseEntity.status(HttpStatus.CONFLICT)
//                        .body("Não é possível deletar: existem filmes vinculados a este streaming");
//            }
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("You can't delete a Streaming that doesn't exist");
//        }
//    }

//    public ResponseEntity<?> deleteStreaming(@PathVariable Long id) {
//        Optional<Streaming> streaming = streamingService.findById(id);
//        if (streaming.isPresent()) {
//            streamingService.deleteById(id);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("You can't delete a Streaming that doesn't exist");
//        }
//    }
}
