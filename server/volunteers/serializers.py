from rest_framework import serializers

from volunteers.models import Volunteer


class VolunteerSerializer(serializers.ModelSerializer):
    class Meta:
        model = Volunteer
        fields = ('user', 'rating')
        read_only_fields = ('rating',)
