package com.bright_side_it.fonotes.common.base;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import generated.fliesenui.core.BrightMarkdown;
import generated.fliesenui.core.FLUIMarkdownFormatting;

/**
 * Created by phhey on 08.12.2017.
 */

public class MarkdownFormattingUtil {
    public static FLUIMarkdownFormatting createMarkdownFormatting(String text) throws Exception {
        int deepestHeading = new BrightMarkdown().getDeepestHeading(text);
        FLUIMarkdownFormatting formatting = new FLUIMarkdownFormatting();
        Map<Integer, Integer> fontSizesMap = new TreeMap<>();
        formatting.setHeadingLevelToFontSizeInMM(fontSizesMap);
        int fontSize = 4;
        for (int i = deepestHeading; i >= 0; i --){
            fontSizesMap.put(i, fontSize);
            fontSize = (int)Math.max(fontSize * 1.2, fontSize + 2);
        }
        return formatting;
    }

    public static void apply(BrightMarkdown markdown, FLUIMarkdownFormatting formatting) {
        if (formatting == null){
            return;
        }

        if (formatting.getHeadingLevelToFontSizeInMM() != null){
            Map<Integer, Integer> map = formatting.getHeadingLevelToFontSizeInMM();
            List<BrightMarkdown.FormattingItem> formattingItems = Arrays.asList(BrightMarkdown.FormattingItem.H1
                    , BrightMarkdown.FormattingItem.H2, BrightMarkdown.FormattingItem.H3 , BrightMarkdown.FormattingItem.H4
                    , BrightMarkdown.FormattingItem.H5);
            for (int i = 0; i < 5; i++){
                Integer size = map.get(new Integer(i));
                if (size != null){
                    markdown.setFontSizeInMM(formattingItems.get(i), size);
                }
            }
        }
    }
}
