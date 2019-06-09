from rest_framework import serializers

from helprequests.models import HelpRequest
from patients.models import Patient


class HelpRequestSerializer(serializers.ModelSerializer):
    address = serializers.SerializerMethodField()

    class Meta:
        model = HelpRequest
        fields = ('id', 'patient', 'title', 'text', 'skill', 'address', 'lat', 'lon')
        read_only_fields = ('patient',)

    # noinspection PyMethodMayBeStatic
    def get_address(self, help_request):
        return help_request.patient.address

    def create(self, validated_data):
        try:
            validated_data['patient'] = self.context['request'].user.patient
        except (Patient.DoesNotExist, AttributeError):
            raise serializers.ValidationError('You do not have patient profile')
        return super().create(validated_data)
