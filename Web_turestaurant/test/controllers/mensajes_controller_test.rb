require 'test_helper'

class MensajesControllerTest < ActionDispatch::IntegrationTest
  test "should get respuesta" do
    get mensajes_respuesta_url
    assert_response :success
  end

end
