package com.stackroute.searchService.service;

import com.stackroute.searchService.exceptions.SearchStringNotFoundException;
import com.stackroute.searchService.model.SearchString;

public interface SearchService {
    public SearchString saveSearchString(SearchString searchString);
    public SearchString getSearchStringById(int searchStringId) throws SearchStringNotFoundException;
}
