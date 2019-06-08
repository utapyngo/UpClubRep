from django.contrib import admin
from django.contrib.auth.admin import UserAdmin
from django.utils.translation import gettext_lazy as _

from patients.admin import PatientInline
from users.models import User
from volunteers.admin import VolunteerInline


@admin.register(User)
class CustomUserAdmin(UserAdmin):
    ordering = ['id']
    inlines = [VolunteerInline, PatientInline]
    fieldsets = (
        (None, {'fields': ('phone_number', 'password')}),
        (_('Personal info'), {'fields': ('first_name', 'last_name', 'email')}),
        (_('Permissions'), {
            'fields': ('is_active', 'is_staff', 'is_superuser', 'groups', 'user_permissions'),
        }),
        (_('Important dates'), {'fields': ('last_login', 'date_joined')}),
    )
