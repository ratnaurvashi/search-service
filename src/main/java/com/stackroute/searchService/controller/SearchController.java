package com.stackroute.searchService.controller;

import com.stackroute.searchService.exceptions.SearchStringNotFoundException;
import com.stackroute.searchService.model.SearchString;
import com.stackroute.searchService.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1")
public class SearchController {

    SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @PostMapping("search")
    public ResponseEntity<?> saveTrack(@RequestBody SearchString searchString){
        ResponseEntity responseEntity;
        try{
            searchService.saveSearchString(searchString);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("search/{searchStringId}")
    public ResponseEntity<?> getTrackById(@PathVariable int searchStringId){
        ResponseEntity responseEntity;
        try {
            responseEntity= new ResponseEntity<SearchString>(searchService.getSearchStringById(searchStringId), HttpStatus.OK);
        } catch (SearchStringNotFoundException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
