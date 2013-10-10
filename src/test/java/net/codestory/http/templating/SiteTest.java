/**
 * Copyright (C) 2013 all@code-story.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package net.codestory.http.templating;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SiteTest {
	Site site = Site.get();

	@Test
	public void pages() {
		List<Map<String, Object>> pages = site.getPages();

		assertThat(pages).hasSize(24);
	}

	@Test
	public void tags() {
		Map<String, List<Map<String, Object>>> tags = site.getTags();

		assertThat(tags).hasSize(3);
		assertThat(tags.get("")).hasSize(22);
		assertThat(tags.get("scala")).hasSize(2);
		assertThat(tags.get("java")).hasSize(1);
	}


	@Test
	public void categories() {
		Map<String, List<Map<String, Object>>> categories = site.getCategories();

		assertThat(categories).hasSize(3);
		assertThat(categories.get("")).hasSize(22);
		assertThat(categories.get("post")).hasSize(1);
		assertThat(categories.get("test")).hasSize(1);
	}
}