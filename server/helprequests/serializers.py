from rest_framework import serializers

from helprequests.models import HelpRequest


class HelpRequestSerializer(serializers.ModelSerializer):
    address = serializers.SerializerMethodField()

    class Meta:
        model = HelpRequest
        fields = ('patient', 'title', 'text', 'skill', 'address')

    # noinspection PyMethodMayBeStatic
    def get_address(self, help_request):
        return help_request.patient.address
