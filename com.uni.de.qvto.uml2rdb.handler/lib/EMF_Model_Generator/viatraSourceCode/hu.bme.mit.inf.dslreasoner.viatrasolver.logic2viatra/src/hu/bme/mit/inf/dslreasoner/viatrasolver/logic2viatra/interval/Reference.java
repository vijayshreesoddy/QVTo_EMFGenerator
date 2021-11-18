/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 btrekkie
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package hu.bme.mit.inf.dslreasoner.viatrasolver.logic2viatra.interval;

/**
 * Wraps a value using reference equality.  In other words, two references are equal only if their values are the same
 * object instance, as in ==.
 * @param <T> The type of value.
 */
class Reference<T> {
    /** The value this wraps. */
    private final T value;

    public Reference(T value) {
        this.value = value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Reference)) {
            return false;
        }
        Reference<?> reference = (Reference<?>)obj;
        return value == reference.value;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(value);
    }
}
