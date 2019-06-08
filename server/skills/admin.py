from django.contrib import admin

from skills.models import Skill


@admin.register(Skill)
class SkillAdmin(admin.ModelAdmin):
    date_hierarchy = 'created'
