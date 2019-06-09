from rest_framework import serializers

from volunteers.models import Volunteer


class VolunteerSerializer(serializers.ModelSerializer):
    reviews_number = serializers.SerializerMethodField()

    class Meta:
        model = Volunteer
        fields = ('user', 'rating', 'skills', 'reviews_number')
        read_only_fields = ('rating',)

    # noinspection PyMethodMayBeStatic
    def get_reviews_number(self, volunteer):
        return volunteer.reviews_received.count()
