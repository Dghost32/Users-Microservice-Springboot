package com.users.users.types;

import java.util.List;
import java.util.Optional;

/**
 * Response
 */
public record Response<T>(T data, Optional<String> message,
                          Optional<List<String>> warnings) {
  // public Response(T data, Optional<String> message, Optional<List<String>>
  // warnings) { this(data, message, warnings);
  //}
  public Response(T data) { this(data, Optional.empty(), Optional.empty()); }

  public Response(T data, String message) {
    this(data, Optional.of(message), Optional.empty());
  }

  public Response(T data, List<String> warnings) {
    this(data, Optional.empty(), Optional.of(warnings));
  }

  public Response(T data, String message, List<String> warnings) {
    this(data, Optional.of(message), Optional.of(warnings));
  }
}
