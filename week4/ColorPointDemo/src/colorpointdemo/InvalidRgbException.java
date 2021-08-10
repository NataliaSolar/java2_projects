/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorpointdemo;

/**
 *
 * @author Natalia Solar
 */
public class InvalidRgbException extends Exception {
    
    /**
     * Constructor that specifies the invalid RGB component in the error message
     * @param colorName the name of RGB component
     * @param rgbElement the invalid RGB component
     */
    public InvalidRgbException(String colorName, int rgbElement){

        super("Error: The value of "+ colorName +  " component of RGB is out of correct range [0;255]: " + rgbElement);
    }    
}
