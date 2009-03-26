package com.opensymphony.sitemesh.html.rules;

import com.opensymphony.sitemesh.tagprocessor.BasicBlockRule;
import com.opensymphony.sitemesh.tagprocessor.Tag;
import com.opensymphony.sitemesh.Content;

import java.io.IOException;

/**
 * Extracts the contents of the <code>&lt;head&gt;</code> tag, remove from the main document
 * and adding under a property called <code>head</code>.
 *
 * @author Joe Walnes
 */
public class HeadExtractingRule extends BasicBlockRule {

    private final Content content;

    public HeadExtractingRule(Content content) {
        super("head");
        this.content = content;
    }

    @Override
    protected Object processStart(Tag tag) throws IOException {
        context.pushBuffer();
        return null;
    }

    @Override
    protected void processEnd(Tag tag, Object data) throws IOException {
        content.addProperty("head", context.currentBufferContents());
        context.popBuffer();
    }

}
