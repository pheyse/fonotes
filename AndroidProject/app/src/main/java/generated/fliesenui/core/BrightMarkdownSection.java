package generated.fliesenui.core;;

import java.util.List;

/**
 *
 * @author Philip Heyse
 *
 */
public class BrightMarkdownSection {
	public enum MDType{ROOT, RAW_LINE, PARAGRAPH, PARAGRAPH_ELEMENT, PLAIN_TEXT, HEADING, HORIZONTAL_RULE, BULLET_POINT, NUMBERED_ITEM, BOLD, ITALIC, UNDERLINE
		, STRIKETHROUGH, LINK, CHECKED_ITEM, UNCHECKED_ITEM, CODE_BLOCK, TABLE_OF_CONTENTS, TABLE_ROW, TABLE_CELL}
	private MDType type;
	private Integer level;
	private String rawText;
	private String originalPlainText;
	private List<BrightMarkdownSection> children;
	private BrightMarkdownSection parent;
	private String location;

	public MDType getType() {
		return type;
	}
	public void setType(MDType type) {
		this.type = type;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public List<BrightMarkdownSection> getChildren() {
		return children;
	}
	public void setChildren(List<BrightMarkdownSection> children) {
		this.children = children;
	}
	public BrightMarkdownSection getParent() {
		return parent;
	}
	public void setParent(BrightMarkdownSection parent) {
		this.parent = parent;
	}
	public String getRawText() {
		return rawText;
	}
	public void setRawText(String rawText) {
		this.rawText = rawText;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOriginalPlainText() {
		return originalPlainText;
	}
	public void setOriginalPlainText(String originalPlainText) {
		this.originalPlainText = originalPlainText;
	}
}
