from django.contrib import admin

from helprequests.models import HelpRequest


@admin.register(HelpRequest)
class HelpRequestAdmin(admin.ModelAdmin):
    date_hierarchy = 'created'
