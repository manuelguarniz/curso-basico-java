package com.platzi.example.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.example.jobsearch.api.APIJobs;
import com.platzi.example.jobsearch.cli.CLIArguments;
import com.platzi.example.jobsearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.platzi.example.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.platzi.example.jobsearch.CommanderFunctions.parseArguments;
import static com.platzi.example.jobsearch.api.APIFunctions.buildAPI;

public class JobSearch {
    public static void main(String[] args) {

        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli -> !cli.isHelp())
                .filter((cli -> cli.getKeyword() != null))
                .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
            .map(JobSearch::executeRequest)
            .orElse(Stream.empty())
            .forEach(System.out::println);

    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        APIJobs api = buildAPI(APIJobs.class, "https://jobs.github.com");

        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
