package com.opensymphony.sitemesh.html.rules;

import com.opensymphony.sitemesh.tagprocessor.BasicRule;
import com.opensymphony.sitemesh.tagprocessor.Tag;
import com.opensymphony.sitemesh.Content;

/**
 * Exports any attributes on the <code>&lt;html&gt;</code> tag
 * as page properties.
 *
 * @author Joe Walnes
 */
public class HtmlAttributesRule extends BasicRule {

    private final Content content;

    public HtmlAttributesRule(Content content) {
        super("html");
        this.content = content;
    }

    @Override
    public void process(Tag tag) {
        if (tag.getType() == Tag.Type.OPEN) {
            for (int i = 0; i < tag.getAttributeCount(); i++) {
                content.addProperty(tag.getAttributeName(i), tag.getAttributeValue(i));
            }
        }
    }

}
