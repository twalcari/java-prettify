// Copyright (C) 2011 Chan Wai Shing
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
 * Lang class for Java Prettify.
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public abstract class Lang {

    protected List<List<Object>> shortcutStylePatterns;
    protected List<List<Object>> fallthroughStylePatterns;
    protected List<Lang> extendedLangs;

    public Lang() {
        shortcutStylePatterns = new ArrayList<List<Object>>();
        fallthroughStylePatterns = new ArrayList<List<Object>>();
        extendedLangs = new ArrayList<Lang>();
    }

    public static List<String> getFileExtensions() {
        return new ArrayList<String>();
    }

    public List<List<Object>> getShortcutStylePatterns() {
        List<List<Object>> returnList = new ArrayList<List<Object>>();
        for (List<Object> shortcutStylePattern : shortcutStylePatterns) {
            returnList.add(new ArrayList<Object>(shortcutStylePattern));
        }
        return returnList;
    }

    public void setShortcutStylePatterns(List<List<Object>> shortcutStylePatterns) {
        if (shortcutStylePatterns == null) {
            this.shortcutStylePatterns = new ArrayList<List<Object>>();
            return;
        }
        List<List<Object>> cloneList = new ArrayList<List<Object>>();
        for (List<Object> shortcutStylePattern : shortcutStylePatterns) {
            cloneList.add(new ArrayList<Object>(shortcutStylePattern));
        }
        this.shortcutStylePatterns = cloneList;
    }

    public List<List<Object>> getFallthroughStylePatterns() {
        List<List<Object>> returnList = new ArrayList<List<Object>>();
        for (List<Object> fallthroughStylePattern : fallthroughStylePatterns) {
            returnList.add(new ArrayList<Object>(fallthroughStylePattern));
        }
        return returnList;
    }

    public void setFallthroughStylePatterns(List<List<Object>> fallthroughStylePatterns) {
        if (fallthroughStylePatterns == null) {
            this.fallthroughStylePatterns = new ArrayList<List<Object>>();
            return;
        }
        List<List<Object>> cloneList = new ArrayList<List<Object>>();
        for (List<Object> fallthroughStylePattern : fallthroughStylePatterns) {
            cloneList.add(new ArrayList<Object>(fallthroughStylePattern));
        }
        this.fallthroughStylePatterns = cloneList;
    }

    public List<Lang> getExtendedLangs() {
        return new ArrayList<Lang>(extendedLangs);
    }

    public void setExtendedLangs(List<Lang> extendedLangs) {
        this.extendedLangs = new ArrayList<Lang>(extendedLangs);
    }
}
