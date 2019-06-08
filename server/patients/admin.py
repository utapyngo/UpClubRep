from django.contrib import admin

from patients.models import Patient


class PatientInline(admin.TabularInline):
    model = Patient


@admin.register(Patient)
class PatientAdmin(admin.ModelAdmin):
    date_hierarchy = 'created'
