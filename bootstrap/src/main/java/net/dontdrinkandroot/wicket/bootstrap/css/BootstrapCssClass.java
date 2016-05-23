/**
 * Copyright (C) 2012-2014 Philip W. Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum BootstrapCssClass implements CssClass
{

	ACTIVE("active"),
	ADD_ON("add-on"),
	ALERT("alert"),
	BADGE("badge"),
	BRAND("brand"),
	BREADCRUMB("breadcrumb"),
	BTN("btn"),
	BTN_GROUP("btn-group"),
	BTN_NAVBAR("btn-navbar"),
	BTN_TOOLBAR("btn-toolbar"),
	CARET("caret"),
	CHECKBOX("checkbox"),
	CLOSE("close"),
	CONTAINER("container"),
	CONTAINER_FLUID("container-fluid"),
	CONTROLS("controls"),
	CONTROL_LABEL("control-label"),
	DISABLED("disabled"),
	DIVIDER("divider"),
	DIVIDER_VERTICAL("divider-vertial"),
	DROPDOWN("dropdown"),
	DROPDOWN_MENU("dropdown-menu"),
	DROPDOWN_SUBMENU("dropdown-submenu"),
	DROPDOWN_TOGGLE("dropdown-toggle"),
	DROPUP("dropup"),
	ERROR("error"),
	FADE("fade"),
	FORM_HORIZONTAL("form-horizontal"),
	FORM_INLINE("form-inline"),
	FORM_SEARCH("form-search"),
	FORM_VERTICAL("form-vertical"),
	HELP_INLINE("help-inline"),
	HELP_BLOCK("help-block"),
	HERO_UNIT("hero-unit"),
	HIDE("hide"),
	ICON_WHITE("icon-white"),
	IMG_CIRCLE("img-circle"),
	@Deprecated IMG_POLAROID("img-polaroid"),
	IMG_ROUNDED("img-rounded"),
	INFO("info"),
	INITIALISM("initialism"),
	INLINE("inline"),
	INPUT_APPEND("input-append"),
	INPUT_MINI("input-mini"),
	INPUT_PREPEND("input-prepend"),
	INPUT_SMALL("input-small"),
	INPUT_MEDIUM("input-medium"),
	INPUT_LARGE("input-large"),
	INPUT_XLARGE("input-xlarge"),
	INPUT_XXLARGE("input-xxlarge"),
	LABEL("label"),
	LEAD("lead"),
	MODAL("modal"),
	MUTED("muted"),
	NAV("nav"),
	NAV_COLLAPSE("nav-collapse"),
	NAV_HEADER("nav-header"),
	NAV_LIST("nav-list"),
	NAV_PILLS("nav-pills"),
	NAV_STACKED("nav-stacked"),
	NAV_TABS("nav-tabs"),
	NAVBAR("navbar"),
	NAVBAR_CONTAINER("navbar-container"),
	NAVBAR_FORM("navbar-form"),
	NAVBAR_INNER("navbar-inner"),
	NAVBAR_FIXED_BOTTOM("navbar-fixed-bottom"),
	NAVBAR_FIXED_TOP("navbar-fixed-top"),
	NAVBAR_SEARCH("navbar-search"),
	NAVBAR_TEXT("navbar-text"),
	NEXT("next"),
	PAGINATION("pagination"),
	PAGE_HEADER("page-header"),
	PAGER("pager"),
	PREVIOUS("previous"),
	PROGRESS("progress"),
	PROGRESS_STRIPED("progress-striped"),
	PULL_LEFT("pull-left"),
	PULL_RIGHT("pull-right"),
	RADIO("radio"),
	ROW("row"),
	ROW_FLUID("row-fluid"),
	SEARCH_QUERY("search-query"),
	SUCCESS("success"),
	TAB_CONTENT("tab-content"),
	TAB_PANE("tab-pane"),
	TABABBLE("tababble"),
	TABLE("table"),
	TABLE_BORDERED("table-bordered"),
	TABLE_CONDENSED("table-condensed"),
	TABLE_STRIPED("table-striped"),
	TABS_BELOW("tabs-below"),
	TABS_LEFT("tabs-left"),
	TABS_RIGHT("tabs-right"),
	TEXT_DANGER("text-danger"),
	TEXT_INFO("text-info"),
	TEXT_MUTED("text-muted"),
	TEXT_SUCCESS("text-success"),
	TEXT_WARNING("text-warning"),
	THUMBNAIL("thumbnail"),
	THUMBNAILS("thumbnails"),
	UNEDITABLE_INPUT("uneditable-input"),
	UNSTYLED("unstyled"),
	WARNING("warning"),
	WELL("well"),
	BTN_BLOCK("btn-block"),
	/* BS3 Additions */
	CLEARFIX("clearfix"),
	FORM_GROUP("form-group"),
	HAS_ERROR("has-error"),
	HAS_SUCCESS("has-success"),
	HAS_WARNING("has-warning"),
	HAS_FEEDBACK("has-feedback"),
	LIST_GROUP("list-group"),
	LIST_GROUP_ITEM("list-group-item"),
	LIST_INLINE("list-inline"),
	LIST_UNSTYLED("list-unstyled"),
	MODAL_BODY("modal-body"),
	MODAL_FOOTER("modal-footer"),
	MODAL_TITLE("modal-title"),
	PANEL("panel"),
	PANEL_BODY("panel-body"),
	PANEL_FOOTER("panel-footer"),
	PANEL_HEADING("panel-heading"),
	PANEL_TITLE("panel-title"),
	IMG_RESPONSIVE("img-responsive"),
	IMG_THUMBNAIL("img-thumbnail");

	private String classString;


	private BootstrapCssClass(String classString)
	{

		this.classString = classString;
	}

	@Override
	public String getClassString()
	{

		return this.classString;
	}

}
