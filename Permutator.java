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
 * This class makes it easy to get permutations of lists of any type
 *
 * @author Ole Krause-Sparmann
 *
 * https://github.com/pixelogik
 *
 * @param <T>
 */
public class Permutator<T> {

    /**
     * Returns list of all permutations of specified input list. If emitAllSizes is true, also permutations
     * with smaller sizes are added to the result list. So for an input of [6, 8, 9] the result list would
     * also contain [6], [6,8], [9], etc.
     *
     * @param listToPermute List to permute.
     * @param emitAllSizes Set this to false to only get permutations of full size (same size as input list).
     * @return
     */
    public List<List<T>> permuteList(List<T> listToPermute, boolean emitAllSizes) {

        // Create result object
        List<List<T>> resultAccumulator = new ArrayList<List<T>>();

        // Create initial left array (this one will grow)
        List<T> initialLeftArray = new ArrayList<T>();

        // Start recursive computation of all permutations
        permuteArrayAndEmitVariants(initialLeftArray, listToPermute, resultAccumulator, emitAllSizes);

        // Return result object
        return resultAccumulator;
    }

    /**
     * Internal method that is used recursively
     *
     * @param leftArray This array will grow on each recursion level
     * @param rightArray This array will shrink on each recursion level
     * @param accum The array collects all the variants / permutations
     * @param emitAllSizes If true also variants smaller than the input list are added to the accumulator
     */
    private void permuteArrayAndEmitVariants(List<T> leftArray, List<T> rightArray, List<List<T>> accum, boolean emitAllSizes) {

        // If right array is empty add full length left array
        if (rightArray.size()==0) {
            accum.add(leftArray);
            return;
        }

        // Recursion will terminate when the rightArray is empty
        for (int k=0; k<rightArray.size(); k++) {
            // Create new left and right array for next invocation of method
            List<T> newLeftArray = new ArrayList<T>(leftArray);
            List<T> newRightArray = new ArrayList<T>(rightArray);

            // Add item from right array to the growing left array
            newLeftArray.add(newRightArray.get(k));

            // Remove item from the shrinking right array
            newRightArray.remove(k);

            // If we should emit all permutation sizes, do it now
            if (emitAllSizes) {
                accum.add(newLeftArray);
            }

            // Continue with this configuration
            permuteArrayAndEmitVariants(newLeftArray, newRightArray, accum, emitAllSizes);
        }
    }
}
