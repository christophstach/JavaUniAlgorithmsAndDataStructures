/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.university.sort.data;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class Student {
    private int mn;
    private String firstName;
    private String lastName;
    private Program program;
    private int gender;

    /**
     * Constructor
     */
    public Student() {
    }

    /**
     * Constructor
     *
     * @param mn        The mn
     * @param firstName The firstName
     * @param lastName  The lastName
     * @param program   The program
     * @param gender    The gender
     */
    public Student(int mn, String firstName, String lastName, Program program, int gender) {
        this.mn = mn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
        this.gender = gender;
    }

    /**
     * Getter for mn
     *
     * @return The mn
     */
    public int getMn() {
        return this.mn;
    }

    /**
     * Setter for mn
     *
     * @param mn The mn
     */
    public void setMn(int mn) {
        this.mn = mn;
    }

    /**
     * Getter for firstName
     *
     * @return The firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter for firstName
     *
     * @param firstName The firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName
     *
     * @return The lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter for lastName
     *
     * @param lastName The lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for program
     *
     * @return The program
     */
    public Program getProgram() {
        return this.program;
    }

    /**
     * Setter for program
     *
     * @param program The program
     */
    public void setProgram(Program program) {
        this.program = program;
    }

    /**
     * Getter for gender
     *
     * @return The gender
     */
    public int getGender() {
        return this.gender;
    }

    /**
     * Setter for gender
     *
     * @param gender The gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * Builds the string representation for a Student
     *
     * @return The string representation for a Student
     */
    @Override
    public String toString() {
        return "Student{" +
            "mn=" + mn +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", program=" + program +
            ", gender=" + gender +
            '}';
    }
}
