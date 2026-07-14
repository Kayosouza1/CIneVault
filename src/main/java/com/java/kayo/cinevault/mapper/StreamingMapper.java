package com.java.kayo.cinevault.mapper;

import com.java.kayo.cinevault.Entity.Streaming;
import com.java.kayo.cinevault.request.StreamingRequest;
import com.java.kayo.cinevault.response.StreamingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {

        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {

        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
