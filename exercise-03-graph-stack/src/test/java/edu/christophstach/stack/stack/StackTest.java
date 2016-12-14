/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.stack.stack;

import edu.christophstach.stack.data.Gender;
import edu.christophstach.stack.data.Program;
import edu.christophstach.stack.data.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/15/16
 */
public class StackTest {
    protected Stackable<Student> stack;
    protected Student[] testStudents;

    @Before
    public void setUp() {
        this.testStudents = new Student[]{
            new Student(0, "Christoph", "Stach", Program.APPLIED_COMPUTING, Gender.MALE),
            new Student(1, "Adrianz", "Saiz Ferri", Program.APPLIED_COMPUTING, Gender.MALE),
            new Student(2, "Laila", " Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE),
            new Student(3, "Laura", "Hartgers", Program.APPLIED_COMPUTING, Gender.FEMALE),
            new Student(4, "Martin", "Johnki", Program.APPLIED_COMPUTING, Gender.MALE),
            new Student(5, "Miles", "Lorenz", Program.APPLIED_COMPUTING, Gender.MALE),
        };

        this.stack = new Stack<>();

        this.stack.push(this.testStudents[0]);
        this.stack.push(this.testStudents[1]);
        this.stack.push(this.testStudents[2]);
        this.stack.push(this.testStudents[3]);
    }

    @Test
    public void testPush() {
        this.stack.push(testStudents[4]);

        Assert.assertEquals(this.testStudents[4], this.stack.pop());
    }

    @Test
    public void testPop() {
        Assert.assertEquals(this.testStudents[3], this.stack.pop());
        Assert.assertEquals(this.testStudents[2], this.stack.pop());
        Assert.assertEquals(this.testStudents[1], this.stack.pop());
        Assert.assertEquals(this.testStudents[0], this.stack.pop());

        Assert.assertEquals(null, this.stack.pop());
        Assert.assertEquals(null, this.stack.pop());
    }

    @Test
    public void testPeak() {
        Assert.assertEquals(this.testStudents[3], this.stack.peak());
        Assert.assertEquals(this.testStudents[3], this.stack.peak());

        this.stack.pop();

        Assert.assertEquals(this.testStudents[2], this.stack.peak());
    }

    @Test
    public void testSize() {
        Assert.assertEquals(4, this.stack.size());

        this.stack.pop();
        Assert.assertEquals(3, this.stack.size());

        this.stack.pop();
        Assert.assertEquals(2, this.stack.size());

        this.stack.pop();
        Assert.assertEquals(1, this.stack.size());

        this.stack.pop();
        Assert.assertEquals(0, this.stack.size());

        this.stack.pop();
        Assert.assertEquals(0, this.stack.size());
    }

    @Test
    public void testEmpty() {
        Assert.assertFalse(this.stack.empty());

        this.stack.pop();
        Assert.assertFalse(this.stack.empty());

        this.stack.pop();
        Assert.assertFalse(this.stack.empty());

        this.stack.pop();
        Assert.assertFalse(this.stack.empty());

        this.stack.pop();
        Assert.assertTrue(this.stack.empty());

        this.stack.push(this.testStudents[0]);
        Assert.assertFalse(this.stack.empty());
    }

    @Test
    public void testClearAll() {
        Assert.assertFalse(this.stack.empty());
        Assert.assertEquals(4, this.stack.size());

        this.stack.clearAll();
        Assert.assertTrue(this.stack.empty());
        Assert.assertEquals(0, this.stack.size());

        this.stack.push(this.testStudents[0]);
        Assert.assertFalse(this.stack.empty());
        Assert.assertEquals(1, this.stack.size());
    }
}
