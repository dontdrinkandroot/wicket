package net.dontdrinkandroot.wicket.behavior.aria;

public enum Aria {

	ACTIVEDESCENDANT("aria-activedescendant", false),
	ATOMIC("aria-atomic", false),
	AUTOCOMPLETE("aria-autocomplete", false),
	BUSY("aria-busy", true),
	CHECKED("aria-checked", true),
	CONTROLS("aria-controls", false),
	DESCIBEDBY("aria-describedby", false),
	DISABLED("aria-disabled", true),
	DROPEFFECT("aria-dropeffect", false),
	EXPANDED("aria-expanded", true),
	FLOWTO("aria-flowto", false),
	GRABBED("aria-grabbed", true),
	HASPOPUP("aria-haspopup", false),
	HIDDEN("aria-hidden", true),
	INVALID("aria-invalid", true),
	LABEL("aria-label", false),
	LABELLEDBY("aria-labelledby", false),
	LEVEL("aria-level", false),
	LIVE("aria-live", false),
	MULTILINE("aria-multiline", false),
	MULTISELECTABLE("aria-multiselectable", false),
	ORIENTATION("aria-orientation", false),
	OWNS("aria-owns", false),
	POSINSET("aria-posinset", false),
	PRESSET("aria-pressed (state)", false),
	READONLY("aria-readonly", false),
	RELEVANT("aria-relevant", false),
	REQUIRED("aria-required", false),
	SELECTED("aria-selected", true),
	SETSIZE("aria-setsize", false),
	SORT("aria-sort", false),
	VALUEMAX("aria-valuemax", false),
	VALUEMIN("aria-valuemin", false),
	VALUENOW("aria-valuenow", false),
	TEXT("aria-valuetext", false);

	private String attribute;

	private boolean withState;


	private Aria(String attribute, boolean withState) {

		this.attribute = attribute;
		this.withState = withState;
	}


	public String getAttribute() {

		return this.attribute;
	}


	public boolean isWithState() {

		return this.withState;
	}

}