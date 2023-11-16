/*


package demos;

import Queue.LinkedQueue;

public class LinkedCaesarCipher {

    private LinkedQueue<Character> caesarQueue = new LinkedQueue<>();

    public LinkedCaesarCipher(int shift) {
        for(int i = 0; i < shift; i++) {
            caesarQueue.enqueue((char) i);
        }
    }


    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for(int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if(Character.isLetter(currentChar)) {
                char encryptedChar = encryptChar(currentChar);
                encryptedMessage.append(encryptedChar);
            } else {
                encryptedMessage.append(currentChar);
            }
        }
        return encryptedMessage.toString();
    }

    private char encryptChar(char currentChar) {
        char upperCaseChar = Character.toUpperCase(currentChar);
        int charIndex = upperCaseChar - 'A';
        char encryptedChar = caesarQueue.get(charIndex);
        return Character.isUpperCase(currentChar) ? encryptedChar : Character.toLowerCase(encryptedChar);
    }

    public String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();
        for(int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if(Character.isLetter(currentChar)) {
                char decryptedChar = decryptChar(currentChar);
                decryptedMessage.append(decryptedChar);
            } else {
                decryptedMessage.append(currentChar);
            }
        }
        return decryptedMessage.toString();
    }


    private char decryptChar(char currentChar) {

        char upperCaseChar = Character.toUpperCase(currentChar);
        int charIndex = caesarQueue.indexOf(upperCaseChar);
        char decryptedChar = (char) ('A' + charIndex);
        return Character.isUpperCase(currentChar) ? decryptedChar : Character.toLowerCase(decryptedChar);
    }




}

      */

