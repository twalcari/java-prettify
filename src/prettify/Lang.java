package prettify;

import java.util.ArrayList;
import java.util.List;

public class Lang {

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
