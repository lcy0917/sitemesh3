package com.opensymphony.sitemesh.html.rules;

import com.opensymphony.sitemesh.tagprocessor.BasicRule;
import com.opensymphony.sitemesh.tagprocessor.Tag;
import com.opensymphony.sitemesh.Content;

/**
 * Extracts the contents of any elements that look like
 * <code>&lt;parameter name='x' value='y'&gt;</code> and write the contents
 * to a page property (<code>page.x=y</code>).
 *
 * <p>This is a cheap and cheerful mechanism for exporting values from content to decorators.</p>
 *
 * @author Joe Walnes
 */
public class ParameterExtractingRule extends BasicRule{

    private final Content content;

    public ParameterExtractingRule(Content content) {
        super("parameter");
        this.content = content;
    }

    @Override
    public void process(Tag tag) {
        content.addProperty("page." + tag.getAttributeValue("name", false), tag.getAttributeValue("value", false));
    }
}
