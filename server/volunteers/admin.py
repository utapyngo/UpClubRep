from django.contrib import admin

from reviews.models import Review
from volunteers.models import Volunteer


class VolunteerInline(admin.TabularInline):
    model = Volunteer


class ReviewInline(admin.TabularInline):
    model = Review
    fk_name = 'to_member'
    extra = 0


@admin.register(Volunteer)
class VolunteerAdmin(admin.ModelAdmin):
    date_hierarchy = 'created'
    inlines = [ReviewInline]
