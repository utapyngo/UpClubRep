from django.contrib import admin

from patients.models import Patient
from reviews.models import Review


class PatientInline(admin.TabularInline):
    model = Patient


class ReviewInline(admin.TabularInline):
    model = Review
    fk_name = 'from_member'
    extra = 0


@admin.register(Patient)
class PatientAdmin(admin.ModelAdmin):
    date_hierarchy = 'created'
    inlines = [ReviewInline]
