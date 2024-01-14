package com.platzi.example.jobsearch.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {
    public static Map<String, Object> toMap(CLIArguments cliArguments) {
        Map<String, Object> params = new HashMap<>();
        params.put("description", cliArguments.getKeyword());
        params.put("location", cliArguments.getLocation());
        params.put("full_time", cliArguments.isFullTime());
        params.put("page", cliArguments.getPage());

        if (cliArguments.isMarkdown()) {
            params.put("markdow", true);
        }
        return params;
    }
}
