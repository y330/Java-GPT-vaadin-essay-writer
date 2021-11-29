package com.webapp;

/**
 * @author avivy
 * @date 11/26/2021
 * @filename GPTInteractionManager.java
 **/

import java.util.ArrayList;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;

public class GPTInteractionManager {
    private String promptText;
    private String result = "";
    private ArrayList<String> essayArray = new ArrayList<String>();

    public GPTInteractionManager() {
        this.promptText = "(Example)The following is a spooky story written for kids, just in time for Halloween. Everyone always talks about the old house at the end of the street, but I couldn't believe what happened when I went inside.";
    }

    public GPTInteractionManager(String prompt) {
        this.promptText = prompt;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<String> getEssayArray() {
        return essayArray;
    }

    public void setEssayArray(ArrayList<String> essayArray) {
        this.essayArray = essayArray;
    }

    public void generateEssayWrapper(String prompt, int numParagraphs) {
        this.promptText = "";
        iterateParagraphs(prompt, numParagraphs);
        System.out.println(this.essayArray);
    }

    public void generateEssayWrapper() {
        this.promptText = "";
        iterateParagraphs(this.promptText, 3);
    }

    /**
     * --write 3 page essay--
     * <p>
     * /*Python:
     * def iterateParagraphs(prompt, numPages):
     * """
     * :param prompt:
     * :param numPages:
     * :return:
     * """
     * for i in range(numPages):
     * generateEssay(prompt)
     * <p>
     * <p>
     * def generateEssay(prompt):
     * """
     * Description: write a paragraph tuning the openai gpt3 parmaters to maximize relevance the content
     * :param prompt:
     * System.out.println("\nBrewing up a story...");
     * CompletionRequest completionRequest = CompletionRequest.builder()
     * .prompt(this.promptText)
     * .temperature(0.0-1.0)
     * .maxTokens(000)
     * .topP(0.0-1.0)
     * .frequencyPenalty(0.0-1.0)
     * .n(0.0-1.0)
     * .bestOf(2)
     * .presencePenalty(0.0-1.0)
     * .echo(true)
     * .build();
     * CompletionResult completion = service.createCompletion("davinci", completionRequest);
     * for (CompletionChoice line : completion.getChoices()) {
     * essayArray.add(line.getText());
     * }
     * System.out.println(essayArray);
     * <p>
     * <p>
     * different custom params:
     * <p>
     * maxlength: max number of words in the generated essay
     * temperature: a float between 0 and 1, defines how much of the probability distribution is
     * used to select the next word.
     * topp: a float between 0 and 1, defines how much of the probability distribution is
     * used to select the next word.
     * topk: a positive integer, defines how many of the top probabilities are used to
     * select the next word.
     * norepeatngramsize: a positive integer, defines how many words back to look for
     * ngram repeats.
     * numreturnsequences: a positive integer, defines the number of sequences to generate.
     * If 1, a single sequence is generated.
     * numbeams: a positive integer, defines how many beams to break the generated sequences
     * into.
     * earlystopping: a boolean, defines whether to stop early if we've reached the
     * numbeams limit.
     * lengthpenalty: a float between 0 and 1, defines how much to penalize short generated
     * sequences.
     * numsamples: a positive integer, defines how many samples to generate.
     * If 1, a single sample is generated.
     * numreturnsequences: a positive integer, defines the number of sequences to generate.
     * If 1, a single sequence is generated.
     * numbeams: a positive integer, defines how many beams to break the generated sequences
     * into.
     * earlystopping: a boolean, defines whether to stop early if we've reached the
     * numbeams limit.
     * lengthpenalty: a float between 0 and 1, defines how much to penalize short generated
     * sequences.
     * numsamples: a positive integer, defines how many samples to generate.
     * If 1, a single sample is generated.
     * numreturnsequences: a positive integer, defines the number of sequences to generate.
     * If 1, a single sequence is generated
     * """
     */

    // convert to java
    private void iterateParagraphs(String prompt, int numParagraphs) {
        this.result = prompt;
        for (int i = 0; i < numParagraphs; i++) {
            generateEssay(this.result);
        }

    }

    private void generateEssay(String prompt) {
        String token = System.getenv("OPENAI_TOKEN");
        OpenAiService service = new OpenAiService(token);

        System.out.println("\nBrewing up a story...");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .temperature(0.7)
                .maxTokens(180)
                .topP(1.0)
                .frequencyPenalty(0.1)
                .presencePenalty(0.7)
                .echo(false)
                .build();
        CompletionResult completion = service.createCompletion("davinci", completionRequest);
        for (CompletionChoice line : completion.getChoices()) {
            essayArray.add(line.getText());
        }

        this.result = prompt + "";
        // print the generated essay
        for (String line : this.essayArray) {
            this.result = this.result + line + "\n";
        }
        // get the completion result
    }

}
