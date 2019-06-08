from rest_framework import serializers

from patients.models import Patient


class PatientSerializer(serializers.ModelSerializer):
    class Meta:
        model = Patient
        fields = ('user', 'requirements', 'invalid_group', 'diagnosis', 'address')
