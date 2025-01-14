Link: https://essay-ai-gpt3.herokuapp.com

<img width="960" alt="image" src="https://user-images.githubusercontent.com/68514914/144498549-53d912af-046a-4003-b428-5aad3fd36c81.png">

## Background

OpenAI best generative language model in 2021, GPT-3, had a maximum token limit of 2048 (1500 words), which created a severe obstacle on generating extra-long articles. I developed an algorithm that enhanced the functionality of GPT-3 to create infinitely long articles, maintaining context throughout.

The algorithm is as follows:
essay = user inputted prompt.
1. essaybot creates a new prompt from \[first few sentences of essay, last few sentences of essay\]
2. gpt-3 sends a response
3. essay = original prompt + response. repeat steps 1,2 n times using the new essay, where n is the number of paragraphs the user requested
Otherwise unacheivable using gpt-3 regularly as it exceeds the max token amount. Additionally, it keeps the context of the essay throughout the whole process.

## Project structure

The project follow Maven's [standard directory layout structure](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html):
- Under the `srs/main/java` are located Application sources
    - `Application.java` is a runnable Java application class and the app's 
      starting point
    - `GPTInteractionManager.java` is a class that interacts with the gpt-3 api, and can use recursion for generating multiple paragraphs.
    - `Essay.java`
    - `MainView.java` is an main Vaadin view
- Under the `src/test` are located the TestBench test files
- `src/main/resources` contains configuration files and static resources
- The `frontend` directory in the root folder contains client-side 
  dependencies and resource files. Example CSS styles used by the application 
  are located under `frontend/styles`

## Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Follow the tutorials at [vaadin.com/tutorials](https://vaadin.com/tutorials).
- Watch training videos and get certified at [vaadin.com/learn/training]( https://vaadin.com/learn/training).
- Create new projects at [start.vaadin.com](https://start.vaadin.com/).
- Search UI components and their usage examples at [vaadin.com/components](https://vaadin.com/components).
- Find a collection of solutions to common use cases in [Vaadin Cookbook](https://cookbook.vaadin.com/).
- Find Add-ons at [vaadin.com/directory](https://vaadin.com/directory).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/vaadin) or join our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin/).
