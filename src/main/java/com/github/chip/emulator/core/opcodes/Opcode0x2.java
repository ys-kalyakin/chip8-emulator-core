/**
 * MIT License
 * Copyright (c) 2017 Helloween
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
package com.github.chip.emulator.core.opcodes;

import com.github.chip.emulator.core.ExecutionContext;
import com.github.chip.emulator.core.exceptions.UnsupportedOpcodeException;
import org.apache.log4j.Logger;

/**
 * 0x2 opcode group handler
 * 0x2NNN - call subroutine at NNN
 *
 * @author helloween
 */
public class Opcode0x2 implements Opcode {
    private static final Logger LOGGER = Logger.getLogger(Opcode0x2.class);

    @Override
    public boolean execute(int opcode, ExecutionContext executionContext) throws UnsupportedOpcodeException {
        int address = opcode & 0x0FFF;
        LOGGER.trace(String.format("call subroutine %#X", address));
        executionContext.getStack().push(executionContext.getOffset());
        executionContext.setOffset(address);
        return false;
    }
}
