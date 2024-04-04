package com.springbootproject.shoutreview.service.response;

import java.util.List;

import com.springbootproject.shoutreview.domain.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {
    
    private String title;
    private Genre genre;
    private Double rating;
    private List<ReviewResponse> reviews;
}
