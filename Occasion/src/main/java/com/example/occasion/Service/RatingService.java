package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.Model.MyService;
import com.example.occasion.Model.Rating;
import com.example.occasion.Repostiroy.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    public List<Rating> getAll(){

        return ratingRepository.findAll();
    }

    public void addRating(Rating rating){

        ratingRepository.save(rating);
    }

    public void updateRating(Integer id, Rating rating){
        Rating c = ratingRepository.findRatingById(id);
        if (c == null)
            throw new ApiException("Not found");
        c.setName(rating.getName());
        ratingRepository.save(c);
    }

    public void deleteRating(Integer id){
        Rating c = ratingRepository.findRatingById(id);
        if (c == null)
            throw new ApiException("Not found");
        ratingRepository.delete(c);
    }

}
