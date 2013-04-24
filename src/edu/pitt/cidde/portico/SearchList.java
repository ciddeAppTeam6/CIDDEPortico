package edu.pitt.cidde.portico;

import android.util.Log;

public class SearchList {

    
    private String[] searchText;
    private String[] resultString;
    private int[] resultInt;
    
    public int pickItemTestingOnly = 0;
    
    // IN: searchText[]    = item strings to search later
    //     resultInt[]      = int value to return for a matched item in searchText 
    //     resultString[]   = String value to return for a matched item in searchText
    public SearchList(String[] searchItems, String[] resultString,  int[] resultInt) 
    {
        this.searchText = searchItems;
        this.resultString = resultString;
        this.resultInt = resultInt;
        
        // [[CREATE/POPULATE DATABASE]]
        // (populate all db fields, ignore nulls)
        
    } // constructor: SearchList()
    
    
    // PURPOSE: take the passed in search term, use it to search the databaes,
    // then return the respective INT value that was passed in earlier
    public String findAndReturnStr(String searchTerm)
    {
        // [[SEARCH DATABASE, RETURN resultString value]]

        
        //STUB>>>>>
        if (pickItemTestingOnly >= searchText.length)
            return null; // no search results
        else
            return resultString[pickItemTestingOnly];
        // <<<STUB
        
        
    } // findAndReturnStr
    
    
    // PURPOSE: take the passed in search term, use it to search the databaes,
    // then return the respective String value that was passed in earlier
    public int findAndReturnInt(String searchTerm)
    {
        // [[SEARCH DATABASE, RETURN resultInt value]]

        
        //STUB>>>>>
        if (pickItemTestingOnly >= searchText.length)
            return -1; // no search results
        else
            return resultInt[pickItemTestingOnly];
        // <<<STUB        


    } // findAndReturnInt
    
    
    // PURPOSE: take the passed in search term, use it to search the database 
    // for the BASE array item (the array that is searched - return entire item string)
    public String findAndReturnFullItem(String searchTerm)
    {
        // [[SEARCH DATABASE, RETURN resultString value]]

        
        //STUB>>>>>
        if (pickItemTestingOnly >= searchText.length)
            return null; // no search results
        else
            return searchText[pickItemTestingOnly];
        // <<<STUB
        
        
    } // findAndReturnFullItem


    
    
    // CODE EXAMPLE - HOW TO USE THIS CLASS to search a list of items...
    // this TEMPORARY method demonstrates how to use and call this 
    // class in order to retrieve an item from a searchable list of items
    private void tempDoNotCallThisTestingONLY()
    {
    	
        // Example data
        // ------------
        String searchText[] = {
                "searchable apple 0", "searchable peach 1",  "searchable pear 2" 
        };
        
        String returnedStr[] = {
                "return this for 0", "return this for 1", "return this for 2" 
        };
    
        int returnedInt[] = { 15, 16, 17 };

        
        // Example usage
        // -------------

        // Create search object>>>
        // searchText = the array that will be searched
        // returnedStr = the array who's element will re returned later, if its
        //      respective searchText item is selected during the search
        // returnedInt = the array who's element will be returned later, if its
        //      respective searchTExt item is selected during the search 
        SearchList sr = new SearchList(searchText, returnedStr, returnedInt);
        
        // perform a search for a string, and print it >>>>
        String rStr = sr.findAndReturnStr("apple"); //search for "apple" in text 
        Log.i("DEBUG", rStr);  // for STUB will only return 1st string item "return this for 0"

        // perform a search or an int and print it>>>>
        int rInt = sr.findAndReturnInt("pear"); //search for "apple" in text
        Log.i("DEBUG", "" + rInt);// for STUB will only return 1st integer array item "15"
        
        // perform a search, and return the origianl searchable string (From the base
        // array) that contains the searchable term
        String rStr2 = sr.findAndReturnFullItem("pear"); //search for "apple" in text
        Log.i("DEBUG", rStr2); // for STUB will "searchable apple 0" 
        
        
        // FORCE the return item to return third item (for STUB and TESTINGO ONLY)
        sr.pickItemTestingOnly = 2; // FORCE a return of item#2 [TESTING ONLY!]
        int rInt2 = sr.findAndReturnInt("pear"); //search for "apple" in text
        Log.i("DEBUG", "" + rInt2);// for STUB will return third int item "17"
    }
    
    
    
    
} // Class SearchList
