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
- Office hours: Mondays 10-11, Tuesdays 12:30-2, Wednesdays 11-12, Thursdays 2-3:30.  Also available by appointment.
- [Canvas page](https://rhodes.instructure.com/courses/6585): Use for grades and online assignment 
submissions. 
- [Syllabus](syllabus/syllabus-241-s24.pdf) and [additional policies](syllabus/additional-policies.pdf).

## Resources

## Calendar
{% for module in site.modules %}
{{ module }}
{% endfor %}

