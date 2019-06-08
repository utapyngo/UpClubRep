from django.contrib import admin

from reviews.admin import ReviewInline
from volunteers.models import Volunteer
from volunteers.models import VolunteerSkill


class VolunteerSkillInline(admin.TabularInline):
    model = VolunteerSkill


class VolunteerInline(admin.TabularInline):
    model = Volunteer


@admin.register(Volunteer)
class VolunteerAdmin(admin.ModelAdmin):
    date_hierarchy = 'created'
    inlines = [VolunteerSkillInline, ReviewInline]


@admin.register(VolunteerSkill)
class VolunteerSkillAdmin(admin.ModelAdmin):
    date_hierarchy = 'created'
