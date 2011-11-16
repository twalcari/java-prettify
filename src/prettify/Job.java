// Copyright (C) 2006 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package prettify;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the job object that similar to those in JavaScript Prettify.
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class Job {

    protected int basePos;
    protected String sourceCode;
    protected List<Object> decorations;

    public Job() {
        decorations = new ArrayList<Object>();
    }

    public Job(int basePos, String sourceCode) {
        this.basePos = basePos;
        this.sourceCode = sourceCode;
    }

    public int getBasePos() {
        return basePos;
    }

    public void setBasePos(int basePos) {
        this.basePos = basePos;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public List<Object> getDecorations() {
        return new ArrayList<Object>(decorations);
    }

    public void setDecorations(List<Object> decorations) {
        if (decorations == null) {
            this.decorations = new ArrayList<Object>();
            return;
        }
        this.decorations = new ArrayList<Object>(decorations);
    }
}
