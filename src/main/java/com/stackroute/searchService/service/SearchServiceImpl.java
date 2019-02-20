package com.stackroute.searchService.service;

import com.stackroute.searchService.exceptions.SearchStringNotFoundException;
import com.stackroute.searchService.model.SearchString;
import com.stackroute.searchService.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    SearchRepository searchRepository;


    @Autowired
    public SearchServiceImpl(SearchRepository searchRepository){
        this.searchRepository = searchRepository;
    }

    @Override
    public SearchString saveSearchString(SearchString searchString) {
        SearchString savedSearchString = searchRepository.save(searchString);
        return savedSearchString;
    }

    @Override
    public SearchString getSearchStringById(int searchStringId) throws SearchStringNotFoundException{
        if(!searchRepository.existsById(searchStringId)){
            throw new SearchStringNotFoundException("Search String Not Found");
        }

        SearchString searchString = searchRepository.findById(searchStringId).get();
        if(searchString==null){
            throw new SearchStringNotFoundException("Search String Not Found");
        }
        return searchString;
    }
}
