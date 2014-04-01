// Copyright (c) 2014 Ole Krause-Sparmann
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Showing how to use the Permutator
 *
 * @author Ole Krause-Sparmann
 *
 * https://github.com/pixelogik
 */
public class Main {

    /**
     * Just using the Permutator
     */
    public static void main(String[] args)  {

        // Doing strings
        List<String> stringList = new ArrayList<String>();
        Permutator<String> stringPermutator = new Permutator<String>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");

        // Only generate full length lists
        List<List<String>> fullStringPermutations = stringPermutator.permuteList(stringList, false);
        System.out.println("Only full length variants:");
        System.out.println(fullStringPermutations);

        // Generate all lists
        List<List<String>> allStringPermutations = stringPermutator.permuteList(stringList, true);
        System.out.println("All variants:");
        System.out.println(allStringPermutations);

        // Doing integers
        List<Integer> intList = new ArrayList<Integer>();
        Permutator<Integer> intPermutator = new Permutator<Integer>();
        intList.add(new Integer(1));
        intList.add(new Integer(8));
        intList.add(new Integer(9));
        intList.add(new Integer(47));

        // Only generate full length lists
        List<List<Integer>> fullIntPermutations = intPermutator.permuteList(intList, false);
        System.out.println("Only full length variants:");
        System.out.println(fullIntPermutations);

        // Generate all lists
        List<List<Integer>> allIntPermutations = intPermutator.permuteList(intList, true);
        System.out.println("All variants:");
        System.out.println(allIntPermutations);
    }

}
