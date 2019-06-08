from django.contrib import admin

from reviews.models import Review


@admin.register(Review)
class ReviewAdmin(admin.ModelAdmin):
    date_hierarchy = 'created'
    search_fields = ('text',)
