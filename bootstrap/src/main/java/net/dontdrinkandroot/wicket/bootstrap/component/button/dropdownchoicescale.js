/*
 * Copyright (C) 2012, 2013 Philip W. Sorst <philip@sorst.net>
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
function scaleDropDownChoices() {
	$.each($('.btn-group.dropdownchoice'), function(index, element) {
		var choice = $(element);
		var links = $('.dropdown-menu li', choice);
		var maxWidth = 0;
		for (var i = 0; i < links.length; i++) {
			var curWidth = $(links[i]).width();
			maxWidth = Math.max(maxWidth, curWidth);
		}
		$('.selection', choice).width(maxWidth);
		$('.dropdown-menu', choice).attr("style", "");
	});
}