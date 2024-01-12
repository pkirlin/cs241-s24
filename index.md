---
layout: home
title: CS 241 - Data Structures and Algorithms
nav_exclude: true
permalink: /:path/
seo:
  type: Course
  name: CS 241 - Data Structures and Algorithms
---

# {{ site.tagline }}
{: .mb-2 }
{{ site.description }}
{: .fs-6 .fw-300 }

{% if site.announcements %}
{{ site.announcements.last }}
[Announcements](announcements.md){: .btn .btn-outline .fs-3 }
{% endif %}

## Administrivia
- Instructor: Phillip Kirlin
- Office hours: Mondays 1-2, Tuesdays 12:30-2, Wednesdays 3-4:30, Thursdays 2-3.  Also available by appointment and over Slack.
- [Canvas page](https://rhodes.instructure.com/courses/5889): Use for grades and online assignment 
submissions. 
- [Syllabus](syllabus/syllabus-ai-f23.pdf) and [additional policies](syllabus/additional-policies.pdf).

## Resources

## Calendar
{% for module in site.modules %}
{{ module }}
{% endfor %}

