package com.oz.weather.utils;

import java.net.URI;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * PathsBuilder.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
public class PathsBuilder {

  private PathsBuilder() {
    super();
  }

  /**
   * Build a URI instance of requested path.
   * @param baseUrl         baseUrl.
   * @param endpointPath    endpointPath.
   * @param queryParams     queryParams.
   * @return URI instance.
   */
  public static URI buildPathAsUri(final String baseUrl, final String endpointPath,
                                   final MultiValueMap<String, String> queryParams) {
    return UriComponentsBuilder
        .fromHttpUrl(baseUrl)
        .path(endpointPath)
        .queryParams(queryParams)
        .build().toUri();
  }
}
