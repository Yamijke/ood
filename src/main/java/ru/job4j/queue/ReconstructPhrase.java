package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        int evenElementsSize = evenElements.size();
        for (int i = 0; i < evenElementsSize; i++) {
            char currentChar = evenElements.poll();
            if (i % 2 == 0) {
                str.append(currentChar);
            }
            evenElements.addLast(currentChar);
        }
        return str.toString();
    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        int descendingElementsSize = descendingElements.size();
        for (int i = 0; i < descendingElementsSize; i++) {
            char currentChar = descendingElements.pollLast();
            str.append(currentChar);
        }
        return str.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
